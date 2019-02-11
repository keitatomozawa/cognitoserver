package com.tomoz.example.cognito;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserResult;

public class CognitoServer {
    /**
     * AWSCredentialsProvider implementation that provides credentials
     * by looking at the: AWS_ACCESS_KEY_ID (or AWS_ACCESS_KEY)
     * and AWS_SECRET_KEY (or AWS_SECRET_ACCESS_KEY) environment variables.
     * If the AWS_SESSION_TOKEN environment variable is also set then temporary credentials will be used.
     */
    static final AWSCognitoIdentityProvider COGNITO_CLIENT =
            AWSCognitoIdentityProviderClientBuilder.standard()
                    .withCredentials(new EnvironmentVariableCredentialsProvider())
                    .withRegion(Regions.AP_NORTHEAST_1)
                    .build();

    static final String USER_POOL_ID = "ユーザープールID";


    void createUser(String userName, String tmpPassword) {
        AdminCreateUserRequest adminCreateUserRequest = new AdminCreateUserRequest();
        adminCreateUserRequest
                .withUserPoolId(USER_POOL_ID)
                .withUsername(userName)
                .withTemporaryPassword(tmpPassword);
        AdminCreateUserResult response = COGNITO_CLIENT.adminCreateUser(adminCreateUserRequest);

    }
}
