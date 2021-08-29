package com.ps.wikisink.service;

import com.ps.wikisink.pojo.WikiData;
import org.springframework.stereotype.Service;

@Service
public class WikiDataFilter {
    private  final String prefixesPattern = "(Special:|User:|File|Image:).*";

    public boolean isValidRecord(final WikiData wikiData) {
        return !wikiData.getPageName().matches(prefixesPattern);
    }
}
