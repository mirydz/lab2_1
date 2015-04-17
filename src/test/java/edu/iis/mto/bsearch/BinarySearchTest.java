package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void ShouldFindElementInSingleElementSequence() {
        int[] seq = { 42 };
        SearchResult result = BinarySearch.search(42, seq);
        assertThat(result.isFound(), is(true));
    }

    @Test
    public void ShouldNotFindElementIfNotInSequence() {
        int[] seq = { 42 };
        SearchResult result = BinarySearch.search(21, seq);
        assertThat(result.isFound(), is(false));
    }

    @Test
    public void ShouldFindElementIfAtBeginning() {
        int[] seq = { 42, 45, 48 };
        SearchResult result = BinarySearch.search(42, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @Test
    public void ShouldFindElementIfAtEnd() {
        int[] seq = { 42, 45, 48 };
        SearchResult result = BinarySearch.search(48, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq.length));
    }

    @Test
    public void ShouldFindElementIfInTheMiddle() {
        int[] seq = { 42, 45, 48, 51, 54 };
        SearchResult result = BinarySearch.search(48, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is( (seq.length+1)/2) );
    }

    @Test
    public void ShouldNotFindElementIfNotInLongerSequence() {
        int[] seq = { 42, 45, 48, 51, 54 };
        SearchResult result = BinarySearch.search(39, seq);
        assertThat(result.isFound(), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgExceptionIfGivenEmptySequence() {
        int[] seq = {};
        BinarySearch.search(42, seq);
    }

}