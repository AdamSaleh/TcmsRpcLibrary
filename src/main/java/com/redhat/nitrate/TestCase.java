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

    public static final int PROPOSED=1;
    public static final int CONFIRMED=2;
    public static final int DISABLED=3;
    public static final int NEED_UPDATE=4;
    
        public Integer case_id;
        public Object create_date;
        public Integer product;
        public Integer category;
        public Integer priority;
        public String summary;
        public Integer case_status;
        public Integer plan;
        public Integer component;
        public String default_tester;
        public String estimated_time;
        public Integer is_automated;
        public Boolean is_automated_proposed;
        public Integer sortkey;
        public String script;
        public String arguments;
        public String requirement;
        public String alias;
        public String action;
        public String effect;
        public String setup;
        public String breakdown;
        public Object tag;
        public Object bug;
    

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
        public Integer product;
        @RequiredField
        public Integer category;
        @RequiredField
        public Integer priority;
        @RequiredField
        public String summary;
        public Integer case_status;
        public Integer plan;
        public Integer component;
        public String default_tester;
        public String estimated_time;
        public Integer is_automated;
        public Boolean is_automated_proposed;
        public Integer sortkey;
        public String script;
        public String arguments;
        public String requirement;
        public String alias;
        public String action;
        public String effect;
        public String setup;
        public String breakdown;
        public Object tag;
        public Object bug;
    }

    public static class detach_bug extends TcmsArrayCommand {

        Integer case_id;
        Integer object_pks;
    }

    public static class filter extends TcmsHashCommand {

        public String summary__icontain;
    }


    public static class get extends TcmsArrayCommand {

        //@RequiredField
        public Integer case_id_integer;
        public String case_id_string;

        public get() {
        }

        public get(Integer case_id_integer) {
            this.case_id_integer = case_id_integer;
        }
        public get(String case_id_string) {
            this.case_id_string = case_id_string;
        }
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