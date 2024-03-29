// Solarquest
// Copyright (C) 2011 Colin Bartolome
// Licensed under the GPL. See LICENSE.txt for details.

package com.crappycomic.solarquest.model;

import java.io.Serializable;
import java.util.*;

// This is kind of annoying
public class RuleSet implements Serializable
{
   private static final long serialVersionUID = 8303657986331898582L;
   
   public static enum RuleType
   {
      BOOLEAN,
      INTEGER,
      RED_SHIFT_ROLL_TYPE,
      TRANSACTION_AVAILABILITY
   }

   public static class Rule<T> extends Pair<String, RuleType>
   {
      private static final long serialVersionUID = -656194308203540151L;

      private Rule(String name, RuleType type)
      {
         super(name, type);
      }
      
      @Override
      public int hashCode()
      {
         return getName().hashCode();
      }
      
      @Override
      public boolean equals(Object other)
      {
         return (other instanceof Rule<?>) && getName().equals(((Rule<?>)other).getName());
      }
      
      public String getName()
      {
         return getFirst();
      }
      
      public RuleType getType()
      {
         return getSecond();
      }
   }
   
   public static enum RedShiftRoll
   {
      DOUBLES,
      MAX_ROLL,
      THIRTEEN
   }
   
   public static enum TransactionAvailability
   {
      NOWHERE,
      STATIONS,
      EVERYWHERE
   }

   public static final Rule<Integer> INITIAL_CASH = new Rule<Integer>("initial_cash", RuleType.INTEGER);
   public static final Rule<Integer> INITIAL_FUEL = new Rule<Integer>("initial_fuel", RuleType.INTEGER);
   public static final Rule<Integer> INITIAL_FUEL_STATIONS = new Rule<Integer>("initial_fuel_stations", RuleType.INTEGER);
   public static final Rule<Integer> TOTAL_FUEL_STATIONS = new Rule<Integer>("total_fuel_stations", RuleType.INTEGER);
   public static final Rule<Integer> PASS_START_CASH = new Rule<Integer>("pass_start_cash", RuleType.INTEGER);
   public static final Rule<Integer> LAND_ON_START_CASH = new Rule<Integer>("land_on_start_cash", RuleType.INTEGER);
   public static final Rule<TransactionAvailability> FUEL_STATION_PURCHASE_AVAILABILITY = new Rule<TransactionAvailability>("fuel_station_purchase_availability", RuleType.TRANSACTION_AVAILABILITY);
   public static final Rule<TransactionAvailability> FUEL_STATION_BUYBACK_AVAILABILITY = new Rule<TransactionAvailability>("fuel_station_buyback_availability", RuleType.TRANSACTION_AVAILABILITY);
   public static final Rule<Boolean> CAN_PLACE_FUEL_STATIONS_ON_ANY_NODE = new Rule<Boolean>("can_place_fuel_stations_on_any_node", RuleType.BOOLEAN);
   public static final Rule<TransactionAvailability> NODE_BUYBACK_AVAILABILITY = new Rule<TransactionAvailability>("node_buyback_availability", RuleType.TRANSACTION_AVAILABILITY);
   public static final Rule<Integer> FUEL_STATION_PRICE = new Rule<Integer>("fuel_station_price", RuleType.INTEGER);
   public static final Rule<Integer> FUEL_PRICE_ON_START = new Rule<Integer>("fuel_price_on_start", RuleType.INTEGER);
   public static final Rule<Integer> MAXIMUM_FUEL = new Rule<Integer>("maximum_fuel", RuleType.INTEGER);
   public static final Rule<Integer> DIE_PIPS = new Rule<Integer>("die_pips", RuleType.INTEGER);
   public static final Rule<Integer> LOW_FUEL = new Rule<Integer>("low_fuel", RuleType.INTEGER);
   public static final Rule<Integer> MINIMUM_FUEL = new Rule<Integer>("minimum_fuel", RuleType.INTEGER);
   public static final Rule<Boolean> LASER_BATTLES_ALLOWED = new Rule<Boolean>("laser_battles_allowed", RuleType.BOOLEAN);
   public static final Rule<Integer> LASER_BATTLE_FUEL_COST = new Rule<Integer>("laser_battle_fuel_cost", RuleType.INTEGER);
   public static final Rule<Integer> LASER_BATTLE_MAXIMUM_DISTANCE = new Rule<Integer>("laser_battle_maximum_distance", RuleType.INTEGER);
   public static final Rule<Integer> LASER_BATTLE_DAMAGE_COST = new Rule<Integer>("laser_battle_damage_cost", RuleType.INTEGER);
   public static final Rule<Boolean> LASERS_CAN_FIRE_FROM_START = new Rule<Boolean>("lasers_can_fire_from_start", RuleType.BOOLEAN);
   public static final Rule<Boolean> LASERS_CAN_FIRE_AT_START = new Rule<Boolean>("lasers_can_fire_at_start", RuleType.BOOLEAN);
   public static final Rule<RedShiftRoll> RED_SHIFT_ROLL = new Rule<RedShiftRoll>("red_shift_roll", RuleType.RED_SHIFT_ROLL_TYPE);
   public static final Rule<Boolean> BYPASS_ALLOWED = new Rule<Boolean>("bypass_allowed", RuleType.BOOLEAN);
   public static final Rule<Integer> BYPASS_CASH = new Rule<Integer>("bypass_cash", RuleType.INTEGER);
   public static final Rule<Boolean> FUEL_AVAILABLE_ON_UNOWNED_NODE = new Rule<Boolean>("fuel_available_on_unowned_node", RuleType.BOOLEAN); // false for Apollo 13
   public static final Rule<Boolean> MUST_REFUEL_AT_DEAD_END = new Rule<Boolean>("must_refuel_at_dead_end", RuleType.BOOLEAN); // maybe true for 1985 but not 1988? (Sinope Rule)

   private static final Map<String, Rule<?>> RULE_NAME_MAP;
   static
   {
      Map<String, Rule<?>> ruleNameMap = new LinkedHashMap<String, Rule<?>>();
      
      ruleNameMap.put(INITIAL_CASH.getName(), INITIAL_CASH);
      ruleNameMap.put(INITIAL_FUEL.getName(), INITIAL_FUEL);
      ruleNameMap.put(INITIAL_FUEL_STATIONS.getName(), INITIAL_FUEL_STATIONS);
      ruleNameMap.put(TOTAL_FUEL_STATIONS.getName(), TOTAL_FUEL_STATIONS);
      ruleNameMap.put(PASS_START_CASH.getName(), PASS_START_CASH);
      ruleNameMap.put(LAND_ON_START_CASH.getName(), LAND_ON_START_CASH);
      ruleNameMap.put(FUEL_STATION_PURCHASE_AVAILABILITY.getName(), FUEL_STATION_PURCHASE_AVAILABILITY);
      ruleNameMap.put(FUEL_STATION_BUYBACK_AVAILABILITY.getName(), FUEL_STATION_BUYBACK_AVAILABILITY);
      ruleNameMap.put(CAN_PLACE_FUEL_STATIONS_ON_ANY_NODE.getName(), CAN_PLACE_FUEL_STATIONS_ON_ANY_NODE);
      ruleNameMap.put(NODE_BUYBACK_AVAILABILITY.getName(), NODE_BUYBACK_AVAILABILITY);
      ruleNameMap.put(FUEL_STATION_PRICE.getName(), FUEL_STATION_PRICE);
      ruleNameMap.put(FUEL_PRICE_ON_START.getName(), FUEL_PRICE_ON_START);
      ruleNameMap.put(MAXIMUM_FUEL.getName(), MAXIMUM_FUEL);
      ruleNameMap.put(DIE_PIPS.getName(), DIE_PIPS);
      ruleNameMap.put(LOW_FUEL.getName(), LOW_FUEL);
      ruleNameMap.put(MINIMUM_FUEL.getName(), MINIMUM_FUEL);
      ruleNameMap.put(LASER_BATTLES_ALLOWED.getName(), LASER_BATTLES_ALLOWED);
      ruleNameMap.put(LASER_BATTLE_FUEL_COST.getName(), LASER_BATTLE_FUEL_COST);
      ruleNameMap.put(LASER_BATTLE_MAXIMUM_DISTANCE.getName(), LASER_BATTLE_MAXIMUM_DISTANCE);
      ruleNameMap.put(LASER_BATTLE_DAMAGE_COST.getName(), LASER_BATTLE_DAMAGE_COST);
      ruleNameMap.put(LASERS_CAN_FIRE_FROM_START.getName(), LASERS_CAN_FIRE_FROM_START);
      ruleNameMap.put(LASERS_CAN_FIRE_AT_START.getName(), LASERS_CAN_FIRE_AT_START);
      ruleNameMap.put(RED_SHIFT_ROLL.getName(), RED_SHIFT_ROLL);
      ruleNameMap.put(BYPASS_ALLOWED.getName(), BYPASS_ALLOWED);
      ruleNameMap.put(BYPASS_CASH.getName(), BYPASS_CASH);
      ruleNameMap.put(FUEL_AVAILABLE_ON_UNOWNED_NODE.getName(), FUEL_AVAILABLE_ON_UNOWNED_NODE);
      ruleNameMap.put(MUST_REFUEL_AT_DEAD_END.getName(), MUST_REFUEL_AT_DEAD_END);
      
      RULE_NAME_MAP = Collections.unmodifiableMap(ruleNameMap);
   }
   
   public static Rule<?> getRule(String name)
   {
      return RULE_NAME_MAP.get(name);
   }
   
   private String id;
   
   private Map<Rule<?>, Object> ruleValueMap = new LinkedHashMap<Rule<?>, Object>();
   
   void setID(String id)
   {
      this.id = id;
   }
   
   String getID()
   {
      return id;
   }
   
   public void setValue(Rule<?> rule, String value)
   {
      if (rule.getType() == RuleType.INTEGER)
         ruleValueMap.put(rule, Integer.parseInt(value));
      else if (rule.getType() == RuleType.BOOLEAN)
         ruleValueMap.put(rule, Boolean.parseBoolean(value));
      else if (rule.getType() == RuleType.RED_SHIFT_ROLL_TYPE)
         ruleValueMap.put(rule, RedShiftRoll.valueOf(value.toUpperCase()));
      else if (rule.getType() == RuleType.TRANSACTION_AVAILABILITY)
         ruleValueMap.put(rule, TransactionAvailability.valueOf(value.toUpperCase()));
   }
   
   public <T> void setValue(Rule<T> rule, T value)
   {
      ruleValueMap.put(rule, value);
   }
   
   @SuppressWarnings("unchecked")
   public <T> T getValue(Rule<T> rule)
   {
      return (T)ruleValueMap.get(rule);
   }
   
   public Set<Rule<?>> getRules()
   {
      return Collections.unmodifiableSet(ruleValueMap.keySet());
   }
   
   public String getValueForManual(Rule<?> rule)
   {
      if (rule.getType() == RuleType.INTEGER)
      {
         return getValue(rule).toString();
      }
      else if (rule.getType() == RuleType.BOOLEAN)
      {
         return getValue(rule).equals(Boolean.TRUE)
            ? "allowed" : "not allowed";
      }
      else if (rule.getType() == RuleType.RED_SHIFT_ROLL_TYPE)
      {
         switch ((RedShiftRoll)getValue(rule))
         {
            case DOUBLES:
               return "doubles";
            case MAX_ROLL:
               return "double " + getValue(DIE_PIPS);
            case THIRTEEN:
               return "a 1 and a 3";
         }
      }
      else if (rule.getType() == RuleType.TRANSACTION_AVAILABILITY)
      {
         switch ((TransactionAvailability)getValue(rule))
         {
            case NOWHERE:
               return "at no time";
            case STATIONS:
               return "at Federation Stations";
            case EVERYWHERE:
               return "at any time";
         }
      }
      
      return "RuleSet.getValueForManual() needs an update!";
   }

   public static boolean isRedShift(RedShiftRoll redShiftRoll, int diePips, int die1, int die2)
   {
      switch (redShiftRoll)
      {
         case DOUBLES:
            return die1 == die2;
         case MAX_ROLL:
            return die1 == diePips && die2 == diePips;
         case THIRTEEN:
            return (die1 == 1 && die2 == 3) || (die1 == 3 && die2 == 1);
      }
      
      return false;
   }
   
   public static boolean isTransactionAvailable(TransactionAvailability availability, Node node)
   {
      switch (availability)
      {
         case NOWHERE:
            return false;
         case STATIONS:
            return node.getType() == Node.Type.STATION;
         case EVERYWHERE:
            return true;
      }
      
      return false;
   }
   
   public int size()
   {
      return ruleValueMap.size();
   }
}
