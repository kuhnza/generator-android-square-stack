package <%= appPackage %>.service;

import <%= appPackage %>.model.PasswordAuthentication;
import <%= appPackage %>.model.User;
import <%= appPackage %>.model.UserToken;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;
import rx.Observable;

/**
 * A sample interface to an API that might exist on your server.
 */
public interface ApiService {

  /**
   * Registers a new user account.
   */
  @POST("/user")
  Observable<User> register(@Body User user);

  /**
   * Perform a user login.
   */
  @POST("/user/login")
  Observable<UserToken> login(@Body PasswordAuthentication authentication);

  /**
   * Perform a user logout.
   */
  @POST("user/logout")
  Observable<Void> logout(@Header("Authorization") UserToken token, @Body User user);
}
