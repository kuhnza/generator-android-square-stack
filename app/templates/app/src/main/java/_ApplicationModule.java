package <%= appPackage %>;

import javax.inject.Singleton;

import com.google.gson.GsonBuilder;
import com.squareup.otto.Bus;

import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.analytics.AnalyticsModule;
import <%= appPackage %>.android.AndroidModule;
import <%= appPackage %>.environment.Environment;
import <%= appPackage %>.environment.EnvironmentModule;
import <%= appPackage %>.repository.JsonSharedPreferencesRepository;
import <%= appPackage %>.service.ApiService;
import <%= appPackage %>.util.gson.GsonModule;
import retrofit.RestAdapter;

@Module(
		includes = {
				AndroidModule.class,
				AnalyticsModule.class,
				EnvironmentModule.class,
				GsonModule.class
		},
		library = true
)
public class ApplicationModule {
	private Application application;

	ApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	@Singleton
	public android.app.Application provideApplication() {
		return application;
	}

	@Provides
	@Singleton
	public Bus providesBus() {
		return new Bus(); // my name is Otto and I love to get blotto
	}

	@Provides
	@Singleton
	JsonSharedPreferencesRepository provideSharedPreferenceRepository(GsonBuilder gsonBuilder, SharedPreferences sharedPreferences) {
		return new JsonSharedPreferencesRepository(gsonBuilder, sharedPreferences);
	}

	@Provides
	@Singleton
	ApiService provideApiService(Environment environment) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setEndpoint(environment.getApiHost() + environment.getApiBasePath())
				.build();
		return restAdapter.create(ApiService.class);
	}
}
