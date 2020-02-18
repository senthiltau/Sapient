package com.xyz.product.prodkart.mapper;

import com.xyz.product.prodkart.domainobject.ClientDO;
import com.xyz.product.prodkart.domainvalue.ClientVO;

public class ClientMapper {

    public static ClientVO mapDomainObjectToDomainValue(final ClientDO clientDO) {
        ClientVO clientVO = new ClientVO();
        clientVO.setClientId(clientDO.getClientId());
        clientVO.setClientName(clientDO.getClientName());
        return clientVO;
    }

    public static ClientDO mapDomainValueToDomainObject(final ClientVO clientVO) {
        ClientDO clientDO = new ClientDO();
        clientDO.setClientId(clientVO.getClientId());
        clientDO.setClientName(clientVO.getClientName());
        return clientDO;
    }
}
