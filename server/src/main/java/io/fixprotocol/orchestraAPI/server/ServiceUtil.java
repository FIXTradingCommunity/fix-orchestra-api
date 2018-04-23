package io.fixprotocol.orchestraAPI.server;

final class ServiceUtil {
  
  /**
   * Test match of search string one or more candidates. The match is case insensitive and the
   * search string is contained within a candidate
   * @param searchString a string to match
   * @param candidates an array of candidates to test for a match
   * @return Returns {@code true} if at least one candidate matches
   */
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
