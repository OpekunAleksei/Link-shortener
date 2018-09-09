package com.opekun.m.linkshortener.service;

import com.opekun.m.linkshortener.api.service.ILinkService;
import com.opekun.m.linkshortener.model.Link;
import com.opekun.m.linkshortener.model.exceptions.GetLinkException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:service-context.xml")
public class LinkServiceImplTest {

    @Autowired
    public ILinkService testLinkService;
    public Link link;

    public LinkServiceImplTest() {
    }

    @Before
    public void setUp() {
        this.link = new Link("1", "url", "asd", 2);
        List<String> tags = new ArrayList<>();
        tags.add("tag");
        this.link.setTags(tags);
        this.link = this.testLinkService.saveUpdateLink(link);
    }

    @After
    public void tearDown() {
        this.testLinkService.deleteLink(link.getId());
    }

    /**
     * Test of getLinkByShortLink method, of class LinkServiceImpl.
     */
    @Test(expected = GetLinkException.class)
    public void testGetLinkByShortLink() throws Exception {
        System.out.println("getLinkByShortLink");
        String shortLink = "sadasdasd";
        Link result = testLinkService.getLinkByShortLink(shortLink);
        assertEquals(this.link, result);

    }

    /**
     * Test of getAllLinks method, of class LinkServiceImpl.
     */
    @Test
    public void testGetAllLinks() {
        System.out.println("getAllLinks");
        List<Link> expResult = null;
        List<Link> result = this.testLinkService.getAllLinks();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of deleteLink method, of class LinkServiceImpl.
     */
    @Test
    public void testDeleteLink() {
        System.out.println("deleteLink");
        String id = "1";
        this.testLinkService.deleteLink(id);
    }

    /**
     * Test of saveUpdateLink method, of class LinkServiceImpl.
     */
    @Test
    public void testSaveUpdateLink() {
        System.out.println("updateLink");
        System.out.println("updateLink");
        this.link.setUrl("fsa1232");
        Link resultUpdate = this.testLinkService.saveUpdateLink(this.link);
        assertEquals(resultUpdate.getUrl(), this.link.getUrl());
    }

    /**
     * Test of getLinkByUrl method, of class LinkServiceImpl.
     */
    @Test
    public void testGetLinkByUrl() {
        System.out.println("getLinkByUrl");
        String url = "url";
        Link result = this.testLinkService.getLinkByUrl(url);
        assertEquals(this.link, result);
    }

    /**
     * Test of getUserLinks method, of class LinkServiceImpl.
     */
    @Test
    public void testGetUserLinks() {
        System.out.println("getUserLinks");
        String userId = "1";
        List<Link> expResult = null;
        List<Link> result = this.testLinkService.getUserLinks(userId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getLinksByTag method, of class LinkServiceImpl.
     */
    @Test
    public void testGetLinksByTag() {
        System.out.println("getLinksByTag");
        String tag = "tag";
        List<Link> expResult = null;
        List<Link> result = this.testLinkService.getLinksByTag(tag);
        assertNotEquals(expResult, result);
    }

}
