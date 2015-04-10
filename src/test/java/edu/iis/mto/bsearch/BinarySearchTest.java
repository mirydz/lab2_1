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

}