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

	@Provides
	@Singleton
	public Environment provideEnvironment() {
		return new ProductionEnvironment();
	}
}
