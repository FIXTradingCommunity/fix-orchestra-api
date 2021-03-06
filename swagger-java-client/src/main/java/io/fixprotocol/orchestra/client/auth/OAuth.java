

package io.fixprotocol.orchestra.client.auth;

import java.util.List;
import java.util.Map;

import io.fixprotocol.orchestra.client.Pair;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-23T17:52:38.213Z")
public class OAuth implements Authentication {
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
    if (accessToken != null) {
      headerParams.put("Authorization", "Bearer " + accessToken);
    }
  }
}
