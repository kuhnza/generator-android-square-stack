package <%= appPackage %>.util.mortar;

import mortar.Mortar;
import mortar.MortarScope;
import mortar.Presenter;

/**
 * A view presenter that's friendly to our *WithViewCallback classes.
 *
 * @param <V> the {@link BaseView} that this presenter is for
 */
public abstract class BaseViewPresenter<V extends BaseView> extends Presenter<V> {
	/**
	 * Returns true if presenter currently holds a view.
	 *
	 * @return true if presenter has view, otherwise false.
	 */
	public boolean hasView() {
		return getView() != null;
	}

	/**
	 * Return the view held by the presenter (if-any)
	 *
	 * @return the view
	 */
	public V view() {
		return getView();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected MortarScope extractScope(V view) {
		return Mortar.getScope(view.getContext());
	}
//
//	/**
//	 * Sets the title of the app toolbar.
//	 *
//	 * @param owner a reference to the {@link au.com.ingogonow.actionbar.ActionBarOwner}
//	 * @param title the title to set
//	 */
//	protected void setAppToolbarTitle(ActionBarOwner owner, String title) {
//		V view = getView();
//		if (view == null) {
//			return;
//		}
//
//		owner.setConfig(new ActionBarConfig.Builder().title(title).build());
//	}
}
