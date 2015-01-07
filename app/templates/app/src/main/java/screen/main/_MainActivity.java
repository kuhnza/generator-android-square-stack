package <%= appPackage %>.screen.main;

import static android.content.Intent.*;

import javax.inject.Inject;

import <%= appPackage %>.R;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.ButterKnife;
import butterknife.InjectView;
import flow.Flow;
import mortar.Mortar;
import mortar.MortarActivityScope;
import mortar.MortarScope;
import <%= appPackage %>.actionbar.ActionBarConfig;
import <%= appPackage %>.actionbar.ActionBarOwner;

public class MainActivity extends ActionBarActivity implements ActionBarOwner.View {

	@Inject MixpanelAPI mixpanel;
	@Inject ActionBarOwner actionBarOwner;

	@InjectView(R.id.app_toolbar) Toolbar actionBarToolbar;
	@InjectView(R.id.container) MainView mainView;

	private MortarActivityScope activityScope;
	private Flow mainFlow;

	@Override
	public Object getSystemService(String name) {
		if (Mortar.isScopeSystemService(name)) {
			return activityScope;
		}
		return super.getSystemService(name);
	}

	/**
	 * Inform the view about back events.
	 */
	@Override
	public void onBackPressed() {
		// Give the view a chance to handle going back. If it declines the honor, let super do its thing.
		if (!mainFlow.goBack()) {
			super.onBackPressed();
		}
	}

	/**
	 * Inform the view about up events.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			return mainFlow.goUp();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setActionBarConfig(ActionBarConfig config) {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar == null) {
			return;
		}


		String title = config.getTitle();
		actionBar.setTitle(title != null ? title : getString(R.string.app_name));

		if (config.isVisible()) {
			actionBar.show();
			mainView.setPadding(0, actionBar.getHeight(), 0, 0);
		} else {
			actionBar.hide();
			mainView.setPadding(0, 0, 0, 0);
		}

		actionBar.setDisplayHomeAsUpEnabled(config.isHomeAsUpEnabled());
	}

	@Override
	public Context getMortarContext() {
		return this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (isWrongInstance()) {
			finish();
			return;
		}

		initActivityScope(savedInstanceState);
		inflateViewContainerLayout();
		configureActionBar();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// activityScope may be null in case isWrongInstance() returned true in onCreate()
		if (isFinishing() && activityScope != null) {
			mixpanel.flush();
			actionBarOwner.dropView(this);

			MortarScope parentScope = Mortar.getScope(getApplication());
			parentScope.destroyChild(activityScope);
			activityScope = null;
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		activityScope.onSaveInstanceState(outState);
	}

	/**
	 * Dev tools and the play store (and others?) launch with a different intent, and so
	 * lead to a redundant instance of this activity being spawned. <a
	 * href="http://stackoverflow.com/questions/17702202/find-out-whether-the-current-activity-will-be-task-root-eventually-after-pendin"
	 * >Details</a>.
	 */
	private boolean isWrongInstance() {
		if (!isTaskRoot()) {
			Intent intent = getIntent();
			boolean isMainAction = intent.getAction() != null && intent.getAction().equals(ACTION_MAIN);
			return intent.hasCategory(CATEGORY_LAUNCHER) && isMainAction;
		}
		return false;
	}

	/**
	 * Configure the app activity bar
	 */
	private void configureActionBar() {
		setSupportActionBar(actionBarToolbar);

		actionBarOwner.takeView(this);
	}

	/**
	 * Inflate the view container layout and inject our view components
	 */
	private void inflateViewContainerLayout() {
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
		mainFlow = mainView.getFlow();
	}

	/**
	 * Initalise the root activity Mortar scope
	 */
	private void initActivityScope(Bundle savedInstanceState) {
		MortarScope parentScope = Mortar.getScope(getApplication());
		activityScope = Mortar.requireActivityScope(parentScope, new MainScreen());
		Mortar.inject(this, this);
		activityScope.onCreate(savedInstanceState);
	}
}
