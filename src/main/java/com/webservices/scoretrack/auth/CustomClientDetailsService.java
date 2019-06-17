package com.webservices.scoretrack.auth;

import com.webservices.scoretrack.domain.Client;
import com.webservices.scoretrack.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomClientDetailsService implements ClientDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = clientRepository.findByClientId(clientId);

        if(client == null) {
            throw new NoSuchClientException("Unknown clientId: [" + clientId + "]");
        }

        OAuth2ClientDetails clientDetails = new OAuth2ClientDetails(clientId, client.getAllowedResourceIDS(),
                client.getScopes(), client.getAuthorizedGrantTypes(), client.getAuthorities(),
                client.getUserAuthorities(), client.getClientType());

        clientDetails.setClientSecret(client.getClientSecret());

        return clientDetails;
    }
}
