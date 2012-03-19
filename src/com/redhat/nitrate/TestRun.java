/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class TestRun {

    public static class add_cases extends TcmsArrayCommand {

        @RequiredField
        public Integer[] case_ids;
        @RequiredField
        public Integer[] run_ids;
    }

    public static class add_tag extends TcmsArrayCommand {

        @RequiredField
        public Integer[] run_ids;
        @RequiredField
        public String[] tags;
    }

    public static class create extends TcmsHashCommand {

        @RequiredField
        public Integer plan;
        @RequiredField
        public Integer build;
        @RequiredField
        public Integer manager;
        @RequiredField
        public String summary;
        @RequiredField
        public Integer product;
        @RequiredField
        public Integer product_version;
        public Integer default_tester;
        public Integer plan_text_version;
        public Object estimated_time;
        public String notes;
        public Integer status;
        public String caseVar;
        public String tag;
    }

    public static class env_value extends TcmsArrayCommand {

        @RequiredField
        public String action;
        @RequiredField
        public Integer runid;
        @RequiredField
        public Integer env_value_id;
    }

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
    }

    public static class get_bugs extends TestRun.get {
    }

    public static class get_env_values extends TestRun.get {
    }

    public static class get_tags extends TestRun.get {
    }

    public static class get_test_case_runs extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
        public Boolean is_current;
    }

    public static class get_test_cases extends TestRun.get {
    }

    public static class get_test_plan extends TestRun.get {
    }

    public static class link_env_value extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
        @RequiredField
        public Integer env_value_id;
    }

    public static class remove_tag extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
        @RequiredField
        public String tag;
    }

    public static class unlink_env_value extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
        @RequiredField
        public Integer env_value_id;
    }

    public static class update extends TcmsArrayCommand {

        @RequiredField
        public Integer id;
        public update.Values values = new Values();

        public static class Values extends TcmsHashCommand {

            Integer plan;
            Integer product;
            Integer build;
            Integer manager;
            Integer default_tester;
            String summary;
            Object estimated_time;
            Integer product_version;
            Integer plan_text_version;
            String notes;
            Integer status;
        }
    }
}
