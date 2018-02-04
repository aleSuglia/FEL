/**
 * Copyright 2016, Yahoo Inc.
 * Licensed under the terms of the Apache License 2.0. See LICENSE file at the project root for terms.
 **/

package com.yahoo.semsearch.fastlinking.view;

import java.util.Comparator;
import java.util.Objects;

/**
 * Simple class to hold a span annotation.
 *
 * @author emeij
 */
public class Span implements Comparable<Span>, Comparator<Span> {

    private String query;
    public String span;
    private Integer startOffset;
    private Integer endOffset;

    Span(String span) {
        this.span = span;
    }

    Span(Span span) {
        this.span = span.span;
        this.startOffset = span.startOffset;
        this.endOffset = span.endOffset;
    }

    public Span(String span, int startOffset, int endOffset) {
        this.span = span;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
    }

    Span(String span, int startOffset, int endOffset, String query) {
        this.span = span;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.query = query;
    }

    /**
     * @return the span in the input that matched.
     */
    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(int startOffset) {
        this.startOffset = startOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(int endOffset) {
        this.endOffset = endOffset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Span span = (Span) o;
        return Objects.equals(startOffset, span.startOffset) &&
                Objects.equals(endOffset, span.endOffset);
    }

    @Override
    public int compareTo(Span span) {
        if (this.startOffset.equals(span.startOffset) && this.endOffset.equals(span.endOffset))
            return 0;

        int compareFirst = this.startOffset.compareTo(span.startOffset);

        if (compareFirst == 0)
            return this.endOffset.compareTo(span.endOffset);

        return compareFirst;
    }

    @Override
    public int compare(Span span1, Span span2) {
        if (span1.startOffset.equals(span2.startOffset) && span1.endOffset.equals(span2.endOffset))
            return 0;

        int compareFirst = span1.startOffset.compareTo(span2.startOffset);

        if (compareFirst == 0)
            return span1.endOffset.compareTo(span2.endOffset);

        return compareFirst;
    }

    @Override
    public int hashCode() {

        return Objects.hash(startOffset, endOffset);
    }

    public String toString() {
        return span;
    }
}
