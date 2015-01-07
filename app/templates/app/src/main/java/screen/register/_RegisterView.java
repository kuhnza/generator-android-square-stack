package <%= appPackage %>.screen.register;

import javax.inject.Inject;

import android.content.Context;
import android.util.AttributeSet;
import mortar.Presenter;
import <%= appPackage %>.util.mortar.BaseView;

public class RegisterView extends BaseView {

	@Inject RegisterPresenter presenter;

	public RegisterView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected Presenter getPresenter() {
		return presenter;
	}
}
