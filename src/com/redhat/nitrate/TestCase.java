/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class TestCase {

    public static class add_comment extends TcmsArrayCommand {

        @RequiredField
        public String case_ids;
        @RequiredField
        public String comment;
    }

    public static class add_component extends TcmsArrayCommand {

        @RequiredField
        public String case_ids;
        @RequiredField
        public String component;
    }

    public static class add_tag extends TcmsArrayCommand {

        @RequiredField
        public Integer[] case_ids;
        @RequiredField
        public String[] tags;
    }

    public static class add_to_run extends TcmsArrayCommand {

        @RequiredField
        public Integer[] case_ids;
        @RequiredField
        public Integer[] run_ids;
    }

    public static class attach_bug extends TcmsHashCommand {

        Integer case_id;
        Integer bug_id;
        Integer bug_system_id;
        String summary;
        String description;
    }

    public static class calculate_average_estimated_time extends TcmsArrayCommand {

        @RequiredField
        public Integer case_ids;
    }

    public static class calculate_total_estimated_time extends TcmsArrayCommand {

        @RequiredField
        public Integer case_ids;
    }

    public static class check_case_status extends TcmsArrayCommand {

        @RequiredField
        public String name;
    }

    public static class check_priority extends TcmsArrayCommand {

        @RequiredField
        public String value;
    }

    public static class create extends TcmsHashCommand {

        @RequiredField
        Integer product;
        @RequiredField
        Integer category;
        @RequiredField
        Integer priority;
        @RequiredField
        String summary;
        Integer case_status;
        Integer plan;
        Integer component;
        String default_tester;
        String estimated_time;
        Integer is_automated;
        Boolean is_automated_proposed;
        Integer sortkey;
        String script;
        String arguments;
        String requirement;
        String alias;
        String action;
        String effect;
        String setup;
        String breakdown;
        String tag;
        String bug;
    }

    public static class detach_bug extends TcmsArrayCommand {

        Integer case_id;
        Integer object_pks;
    }

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer case_id;
    }

    public static class get_bug_systems extends TestCase.get {
    }

    public static class get_bugs extends TestCase.get {
    }

    public static class get_case_run_history extends TestCase.get {
    }

    public static class get_case_status extends TestCase.get {
    }

    public static class get_change_history extends TestCase.get {
    }

    public static class get_components extends TestCase.get {
    }

    public static class get_plans extends TestCase.get {
    }

    public static class get_priority extends TestCase.get {
    }

    public static class get_tags extends TestCase.get {
    }

    public static class get_text extends TcmsArrayCommand {
        @RequiredField
        public Integer case_id;
        Integer version;
    }

    public static class link_plan extends TcmsArrayCommand {
        @RequiredField
        public Integer case_ids;
        @RequiredField
        public Integer plan_ids;
        @RequiredField
        public Boolean force;
    }
    public static class remove_component extends TcmsArrayCommand {
        @RequiredField
        public Integer case_ids;
        @RequiredField
        public Integer component_ids;
    }
    public static class remove_tag extends TcmsArrayCommand {
        @RequiredField
        public Integer case_ids;
        @RequiredField
        public String tags;
    }
    public static class store_text extends TcmsArrayCommand {
        @RequiredField
        public Integer x0case_ids;
        @RequiredField
        public String x1action;
        @RequiredField
        public String x2effect;
        @RequiredField
        public String x3setup;
        @RequiredField
        public String x4breakdown;
    }
    public static class unlink_plan extends TcmsArrayCommand {
        @RequiredField
        public Integer case_ids;
        @RequiredField
        public Integer plan_ids;
    }

    public static class update extends TcmsArrayCommand{
         @RequiredField
         public Integer id;
         public create values=new create();
    }
}