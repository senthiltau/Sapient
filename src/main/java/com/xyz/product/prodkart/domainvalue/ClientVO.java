package com.xyz.product.prodkart.domainvalue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientVO {

    private Long clientId;

    @ApiModelProperty(value = "Client name")
    @NotNull(message = "Client name cannot null")
    private String clientName;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientVO clientVO = (ClientVO) o;
        return Objects.equals(clientId, clientVO.clientId) &&
                Objects.equals(clientName, clientVO.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName);
    }

    @Override
    public String toString() {
        return "ClientVO{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
