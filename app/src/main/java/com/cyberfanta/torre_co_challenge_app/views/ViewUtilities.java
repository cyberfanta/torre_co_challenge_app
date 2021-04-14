package com.cyberfanta.torre_co_challenge_app.views;

import android.annotation.SuppressLint;
import android.content.Context;

import com.cyberfanta.torre_co_challenge_app.R;

public class ViewUtilities {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void setContext(Context context) {
        ViewUtilities.context = context;
    }

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

    public static String translateStrings(String string) {
        return translateStrings(context, string);
    }

    public static String translateStrings(Context context, String string) {
        if (string == null)
            return "";

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
            case "french":
            case "frances":
                return context.getString(R.string.french);
            case "german":
            case "aleman":
            case "alemán":
                return context.getString(R.string.german);
            case "italian":
            case "italiano":
                return context.getString(R.string.italian);
            case "chinese":
            case "chino":
                return context.getString(R.string.chinese);
            case "japanese":
            case "japan":
            case "japones":
            case "japonés":
                return context.getString(R.string.japanese);

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

            case "january":
                return context.getString(R.string.january);
            case "february":
                return context.getString(R.string.february);
            case "march":
                return context.getString(R.string.march);
            case "april":
                return context.getString(R.string.april);
            case "may":
                return context.getString(R.string.may);
            case "june":
                return context.getString(R.string.june);
            case "july":
                return context.getString(R.string.july);
            case "august":
                return context.getString(R.string.august);
            case "september":
                return context.getString(R.string.september);
            case "october":
                return context.getString(R.string.october);
            case "november":
                return context.getString(R.string.november);
            case "december":
                return context.getString(R.string.december);

            case "city":
                return context.getString(R.string.city);
            case "country":
                return context.getString(R.string.country);
            case "latitude":
                return context.getString(R.string.latitude);
            case "longitude":
                return context.getString(R.string.longitude);
            case "timezone":
                return context.getString(R.string.timezone);
            case "timezone_offset":
                return context.getString(R.string.timezone_offset);

            case "mentoring":
                return context.getString(R.string.mentoring);
            case "advising":
                return context.getString(R.string.advising);
            case "hiring":
                return context.getString(R.string.hiring);
            case "gigs":
            case "freelance-gigs":
                return context.getString(R.string.freelance_gigs);
            case "full-time-employment":
                return context.getString(R.string.full_time_employment);
            case "part-time-employment":
                return context.getString(R.string.part_time_employment);
            case "industries":
                return context.getString(R.string.industries);
            case "internship":
            case "internships":
                return context.getString(R.string.internship);

            case "desirable-compensation-currency":
                return context.getString(R.string.desirable_compensation_currency);
            case "desirable-compensation-amount":
                return context.getString(R.string.desirable_compensation_amount);
            case "desirable-compensation-periodicity":
                return context.getString(R.string.desirable_compensation_periodicity);

            case "no_open_to":
                return context.getString(R.string.no_open_to);
            case "open_to":
                return context.getString(R.string.open_to);

            default:
                return string;
        }
    }
}
