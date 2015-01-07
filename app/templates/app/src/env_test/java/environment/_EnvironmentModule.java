package <%= appPackage %>.environment;

import static com.atomicleopard.expressive.Expressive.map;

import java.util.Map;

import javax.inject.Singleton;

import android.content.SharedPreferences;
import dagger.Provides;
import <%= appPackage %>.SharedPreferencesKeys;

@dagger.Module(
		library = true,
		complete = false
)
public class EnvironmentModule {

	private static final Environment LOCAL_ENVIRONMENT = new LocalEnvironment();
	private static final Environment DEVELOPMENT_ENVIRONMENT = new DevelopmentEnvironment();
	private static final Environment UAT_ENVIRONMENT = new UatEnvironment();

	private static Map<String, Environment> ENVIRONMENTS = map(
			LOCAL_ENVIRONMENT.getName(), LOCAL_ENVIRONMENT,
      DEVELOPMENT_ENVIRONMENT.getName(), DEVELOPMENT_ENVIRONMENT,
      UAT_ENVIRONMENT.getName(), UAT_ENVIRONMENT
	);

	@Provides
	@Singleton
	public Environment provideEnvironment(SharedPreferences preferences) {
		String environmentName = preferences.getString(SharedPreferencesKeys.ENVIRONMENT, null);
		return getEnvironment(environmentName);
	}

	/**
	 * Get the environment with the given name or {@link passenger.environment.EnvironmentModule#LOCAL_ENVIRONMENT} if no match found.
	 *
	 * @param name the environment name.
	 * @return the corresponding environment.
	 */
	private Environment getEnvironment(String name) {
		Environment environment = ENVIRONMENTS.get(name);
		return environment != null ? environment : LOCAL_ENVIRONMENT;
	}
}
