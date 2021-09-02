package com.ps.wikisink.service;

import com.ps.wikisink.pojo.WikiData;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Setter
public class WikiDataFilter {

    @Value("${application.data.pattern-to-skip}")
    private String prefixesPattern;

    public boolean isValidRecord(final WikiData wikiData) {
        return !wikiData.getPageName().matches(prefixesPattern);
    }
}
