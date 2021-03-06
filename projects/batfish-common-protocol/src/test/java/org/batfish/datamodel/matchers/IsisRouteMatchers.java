package org.batfish.datamodel.matchers;

import static org.batfish.datamodel.matchers.AbstractRouteMatchers.hasMetric;
import static org.batfish.datamodel.matchers.AbstractRouteMatchers.hasNextHopIp;
import static org.batfish.datamodel.matchers.AbstractRouteMatchers.hasPrefix;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;

import javax.annotation.Nonnull;
import org.batfish.datamodel.AbstractRoute;
import org.batfish.datamodel.Ip;
import org.batfish.datamodel.IsisRoute;
import org.batfish.datamodel.Prefix;
import org.batfish.datamodel.matchers.IsisRouteMatchersImpl.HasDown;
import org.batfish.datamodel.matchers.IsisRouteMatchersImpl.IsIsisRouteThat;
import org.hamcrest.Matcher;

public final class IsisRouteMatchers {

  public static @Nonnull Matcher<IsisRoute> hasDown() {
    return new HasDown(equalTo(true));
  }

  /** Matches with a route with the given prefix and next hop IP */
  public static Matcher<AbstractRoute> isisRouteTo(Prefix prefix, Ip nextHopIp, long metric) {
    return allOf(
        isIsisRouteThat(hasPrefix(prefix)),
        isIsisRouteThat(hasNextHopIp(equalTo(nextHopIp))),
        isIsisRouteThat(hasMetric(metric)));
  }

  public static @Nonnull Matcher<AbstractRoute> isIsisRouteThat(
      @Nonnull Matcher<? super IsisRoute> subMatcher) {
    return new IsIsisRouteThat(subMatcher);
  }

  private IsisRouteMatchers() {}
}
