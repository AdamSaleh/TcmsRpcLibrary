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
}