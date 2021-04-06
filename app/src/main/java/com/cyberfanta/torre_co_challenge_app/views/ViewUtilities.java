package com.cyberfanta.torre_co_challenge_app.views;

import android.content.Context;

import com.cyberfanta.torre_co_challenge_app.R;

public class ViewUtilities {
    public static String filterWebAnnotations(String string) {
        string = string.replaceAll("<p>", "");
        string = string.replaceAll("</p>", "\n");
        string = string.replaceAll("&aacute;", "á");
        string = string.replaceAll("&eacute;", "é");
        string = string.replaceAll("&iacute;", "í");
        string = string.replaceAll("&oacute;", "ó");
        string = string.replaceAll("&uacute;", "ú");
        string = string.replaceAll("<b>", "");
        string = string.replaceAll("</b>", "");
        string = string.replaceAll("<br/>", "");
        string = string.replaceAll("<ul>", "");
        string = string.replaceAll("</ul>", "");
        string = string.replaceAll("<li>", "- ");
        string = string.replaceAll("</li>", "\n");
        return string;
    }

    public static String translateStrings(Context context, String string) {
        switch (string) {
            case "plus_year":
                return context.getString(R.string.plus_year);
            case "potential_to_develop":
                return context.getString(R.string.potential_to_develop);
            case "remote":
                return context.getString(R.string.remote);
            case "anywhere":
                return context.getString(R.string.anywhere);
            case "in":
                return context.getString(R.string.in);
            case "type":
                return context.getString(R.string.type);
            case "benefits":
                return context.getString(R.string.benefits);
            case "reason":
                return context.getString(R.string.reason);
            case "responsibilities":
                return context.getString(R.string.responsibilities);
            case "requirements":
                return context.getString(R.string.requirements);
            case "challenges":
                return context.getString(R.string.challenges);
            case "career_path":
                return context.getString(R.string.career_path);
            case "organizations":
                return context.getString(R.string.organizations);
            case "team_culture":
                return context.getString(R.string.team_culture);
            case "stock_compensations":
                return context.getString(R.string.stock_compensations);
            case "deseable":
            case "desirable":
                return context.getString(R.string.desirable);
            case "team_structure":
                return context.getString(R.string.team_structure);
            case "additional":
                return context.getString(R.string.additional);
            case "conversational":
                return context.getString(R.string.conversational);
            case "fully_fluent":
                return context.getString(R.string.fully_fluent);
            case "reading":
                return context.getString(R.string.reading);
            case "english":
            case "ingles":
            case "inglés":
                return context.getString(R.string.english);
            case "spanish":
            case "espanol":
            case "español":
                return context.getString(R.string.spanish);

            case "category":
                return context.getString(R.string.category);
            case "jobs":
                return context.getString(R.string.jobs);
            case "education":
                return context.getString(R.string.education);
            case "projects":
                return context.getString(R.string.projects);
            case "publications":
                return context.getString(R.string.publications);
            case "awards":
                return context.getString(R.string.awards);
            case "organization":
                return context.getString(R.string.organization);
            case "name":
                return context.getString(R.string.name);
            case "from":
                return context.getString(R.string.from);
            case "to":
                return context.getString(R.string.to);
//            case "español":
//                return context.getString(R.string.spanish);



            default:
                return string;
        }
    }
}
