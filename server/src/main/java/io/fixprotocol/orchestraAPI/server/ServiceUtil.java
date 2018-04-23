package io.fixprotocol.orchestraAPI.server;

final class ServiceUtil {
  
  public static boolean isMatch(String searchString, String[] candidates) {
    if (searchString != null && candidates != null && candidates.length > 0) {
      final String searchToLower = searchString.toLowerCase();
      for (String candidate : candidates) {
        if (candidate != null) {
          if (candidate.toLowerCase().contains(searchToLower)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
