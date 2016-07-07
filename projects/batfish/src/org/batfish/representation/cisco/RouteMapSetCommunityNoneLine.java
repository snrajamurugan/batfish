package org.batfish.representation.cisco;

import java.util.List;

import org.batfish.datamodel.Configuration;
import org.batfish.datamodel.PolicyMapSetCommunityNoneLine;
import org.batfish.datamodel.PolicyMapSetLine;
import org.batfish.datamodel.routing_policy.statement.Statement;
import org.batfish.datamodel.routing_policy.statement.Statements;
import org.batfish.main.Warnings;

public class RouteMapSetCommunityNoneLine extends RouteMapSetLine {

   private static final long serialVersionUID = 1L;

   @Override
   public void applyTo(List<Statement> statements, CiscoConfiguration cc,
         Configuration c, Warnings w) {
      statements.add(Statements.DeleteAllCommunities.toStaticStatement());
   }

   @Override
   public RouteMapSetType getType() {
      return RouteMapSetType.COMMUNITY_NONE;
   }

   @Override
   public PolicyMapSetLine toPolicyMapSetLine(CiscoConfiguration v,
         Configuration c, Warnings w) {
      return new PolicyMapSetCommunityNoneLine();
   }

}
