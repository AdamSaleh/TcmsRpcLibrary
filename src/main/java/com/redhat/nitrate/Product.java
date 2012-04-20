/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class Product {

    public Integer id;  
    public Integer classification_id;
    public Boolean disallow_new;
    public Integer max_vote_super_bug;
    public String default_milestone;
    public String description;
    public String name;
    public String classification;  
    public Boolean votes_to_confirm;    
    public String milestone_url;
    public Integer vote_super_user;
    //public Integer votes_to_confirm;

    public static class check_category extends TcmsArrayCommand {

        @RequiredField
        public String name;
        @RequiredField
        public Integer product;
    }

    public static class check_component extends Product.check_category {
    }

    public static class check_product extends TcmsArrayCommand {

        @RequiredField
        public String name;
    }

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer id;
        public String id_str;
    };

    public static class get_builds extends Product.get {
    }

    public static class get_cases extends Product.get {
    }

    public static class get_categories extends Product.get {
    }

    public static class get_category extends Product.get {
    }

    public static class get_component extends Product.get {
    }

    public static class get_components extends Product.get {
    }
    public static class get_plans extends Product.get {
    }
    public static class get_runs extends Product.get {
    }
    public static class get_tags extends Product.get {
    }
    public static class get_versions extends Product.get {
    }
    
    public static class Version{
        public Integer id;
        public String value;
        public String product;
        public Integer product_id;

    }
    
    public static class Category{
        public Integer id;
        public String name;
        public String product;
        public String description;
        public Integer product_id;

    }
}
