package <%= appPackage %>.actionbar;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Configuration which can be applied to an ActionBar via the ActionBarOwner.
 */
public class ActionBarConfig {

	private final String title;
	private final boolean visible;
	private final boolean enableHomeAsUp;

	ActionBarConfig(Builder builder) {
		title = builder.title;
		visible = builder.visible;
		enableHomeAsUp = builder.enableHomeAsUp;
	}

	/**
	 * Get the action bar title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * True if the action bar should be shown, false if it should be hidden.
	 *
	 * @return true if visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * True if the up button has been enabled.
	 *
	 * @return true if enabled
	 */
	public boolean isHomeAsUpEnabled() {
		return enableHomeAsUp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ActionBarConfig that = (ActionBarConfig) o;

		if (visible != that.visible) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (visible ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("title", title)
				.append("visible", visible)
				.toString();
	}

	/**
	 * Builds an {@link passenger.actionbar.ActionBarConfig}.
	 */
	public static class Builder {
		private String title;
		private boolean visible = true;
		private boolean enableHomeAsUp = true;

		/**
		 * Sets the title of the ActionBar. Defaults to the app name.
		 *
		 * @param title the title to set
		 * @return this
		 */
		public Builder title(String title) {
			this.title = title;
			return this;
		}

		/**
		 * Sets the visibility of the ActionBar. Defaults to true.
		 *
		 * @param visible true to show, false to hide
		 * @return this
		 */
		public Builder visible(boolean visible) {
			this.visible = visible;
			return this;
		}

		/**
		 * Enables the up button in the ActionBar. Defaults to true.
		 *
		 * @param enabled true to enable, false to disable
		 * @return this
		 */
		public Builder enableHomeAsUp(boolean enabled) {
			this.enableHomeAsUp = enabled;
			return this;
		}

		/**
		 * Builds the ActionBarConfig.
		 *
		 * @return a new ActionBarConfig instance
		 */
		public ActionBarConfig build() {
			return new ActionBarConfig(this);
		}
	}
}
