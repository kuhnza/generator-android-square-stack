package <%= appPackage %>.screen.register;

import javax.inject.Inject;

import android.os.Bundle;
import <%= appPackage %>.actionbar.ActionBarConfig;
import <%= appPackage %>.actionbar.ActionBarOwner;
import <%= appPackage %>.util.mortar.BaseViewPresenter;

class RegisterPresenter extends BaseViewPresenter<RegisterView> {

	private ActionBarOwner actionBarOwner;

	@Inject
	RegisterPresenter(ActionBarOwner actionBarOwner) {
		this.actionBarOwner = actionBarOwner;
	}

	@Override
	protected void onLoad(Bundle savedInstanceState) {
		super.onLoad(savedInstanceState);

		RegisterView view = getView();
		if (view != null) {
			configureActionBar();
		}
	}

	private void configureActionBar() {
		ActionBarConfig config = new ActionBarConfig.Builder()
				.title("Register")
				.build();
		actionBarOwner.setConfig(config);
	}
}
