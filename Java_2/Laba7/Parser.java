package com.lablll.labwork7;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://stackoverflow.com/questions/45305283/parsing-sql-query-in-java
 */
public class Parser {
    private static final Pattern CONST_PATTERN
            = Pattern.compile("([^0-9a-zA-Z])((?:[0-9]+(?:\\.[0-9]*)?|[0-9]*\\.[0-9]+)"
            + "(?:[Ee][+-][0-9]+])?"
            + "|(?:\\'[^']*\\')+)", Pattern.CASE_INSENSITIVE);

    public static class ParameterizedQuery {

        String sql;
        Parameter[] params;

        ParameterizedQuery(String sql, Parameter[] params) {
            this.sql = sql;
            this.params = params.clone();
        }

        public Parameter[] getParams() {
            return params;
        }
    }

    static class Parameter {
        final int position;
        final String value;

        Parameter(int position, String value) {
            this.position = position;
            this.value = value;
        }
    }

    static ParameterizedQuery parse(String query) {
        List<Parameter> parameters = new ArrayList<>();
        Matcher matcher = CONST_PATTERN.matcher(query);
        int start = 0;
        StringBuilder buf = new StringBuilder();
        while (matcher.find()) {
            int pos = matcher.start();
            buf.append(query, start, pos)
                    .append(matcher.group(1))
                    .append("?");
            parameters.add(new Parameter(buf.length() - 1, matcher.group(2)));
            start = matcher.end();
        }
        buf.append(query, start, query.length());
        return new ParameterizedQuery(
                buf.toString(), parameters.toArray(new Parameter[0]));
    }
}


