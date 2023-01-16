package at.fhtw.swen3.unitTests.service.impl;

import at.fhtw.swen3.gps.service.impl.MapsEncodingProxy;
import at.fhtw.swen3.model.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapsEncodingProxyTest {

    @Test
    void encodeAddress() {
        Address address = new Address("Tigergasse 22","1080","Wien","Austria");

        MapsEncodingProxy mapsEncodingProxy = new MapsEncodingProxy();

        assertEquals(48.2089988,mapsEncodingProxy.encodeAddress(address).getLat());
        assertEquals(16.3449887,mapsEncodingProxy.encodeAddress(address).getLon());

    }
}