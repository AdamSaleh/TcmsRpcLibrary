/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate.command;

import com.redhat.nitrate.RequiredField;
import com.redhat.nitrate.TcmsArrayCommand;
import com.redhat.nitrate.TcmsHashCommand;
import redstone.xmlrpc.XmlRpcArray;

/**
 *
 * @author asaleh
 */
public class TestRun {
    
    // OK
    public String summary;
    public String case_run_status;
    public XmlRpcArray env_value;
    public String product_version;
    public String manager;
    public String default_tester;
    public XmlRpcArray tag;
    public Integer manager_id;
    public String stop_date;
    public Integer plan_text_version;
    public String build;
    public String errata_id;
    public Integer plan_id;
    public String plan;
    public Integer run_id;
    public String estimated_time;
    public Integer default_tester_id;
    public Integer build_id;
    public Integer environment_id;
    public String notes;
    public String start_date;
    public XmlRpcArray cc;
    
    
    

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

    public static class filter extends TcmsHashCommand {

        public Integer build;
        public Integer plan;
        public Integer product;
        public Integer manager;
        public String  summary;

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

            public Integer plan;
            public Integer product;
            public Integer build;
            public Integer manager;
            public Integer default_tester;
            public String summary;
            public Object estimated_time;
            public Integer product_version;
            public Integer plan_text_version;
            public String notes;
            public Integer status;
        }
    }
}
