package com.ps.wikisink.service;

import com.ps.wikisink.pojo.WikiData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WikiDataFilterTest {

    WikiDataFilter wikiDataFilter;

    @ParameterizedTest
    @ValueSource( strings= {"File:test", "User:test2", "Special:test", "Image:test", "File:/sdgsd//dsf", "Special:dfdsadg"})
    public void isValidRecord_False(String pageName){
        wikiDataFilter=new WikiDataFilter();
        wikiDataFilter.setPrefixesPattern("(Special:|User:|File|Image:).*");
        Assertions.assertFalse(wikiDataFilter.isValidRecord(WikiData.newBuilder().setPageName(pageName).setRecordId(1).setBytesTransferred(1l).setHourOfDay(0).setNonUniqueViews(1).setYearMonthDay(2020).setLanguage("en").build()));
    }

    @ParameterizedTest
    @ValueSource( strings= {"user test", "pagef", "pagen", "helloworld", "test:do it", "timd special : data"})
    public void isValidRecord_True(String pageName){
        wikiDataFilter=new WikiDataFilter();
        wikiDataFilter.setPrefixesPattern("(Special:|User:|File|Image:).*");
        Assertions.assertTrue(wikiDataFilter.isValidRecord(WikiData.newBuilder().setPageName(pageName).setRecordId(1).setBytesTransferred(1l).setHourOfDay(0).setNonUniqueViews(1).setYearMonthDay(2020).setLanguage("en").build()));
    }

}