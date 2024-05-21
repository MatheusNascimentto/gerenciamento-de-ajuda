package com.gerenciamento.solidariza.config.swagger;

import lombok.Data;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Data
public class CustomOpenApiConfiguration {

    private String headerUserId = "user-id";

    private String version = "1.0.0";

    private String module;

    public CustomOpenApiConfiguration(String module) {
        this.module = module;
    }

    public CustomOpenApiConfiguration(String version, String module) {
        this.version = version;
        this.module = module;
    }

    public OpenAPI buider() {

        SecurityScheme securityUserId = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .name(headerUserId);

        Components components = new Components()
                .addSecuritySchemes(headerUserId, securityUserId);

        Info info = new Info()
                .version(version)
                .title("Gerenciamento de Ajuda - " + module)
                .description("API Rest da aplicação Gerenciamento de Ajuda");

        return new OpenAPI().components(components).info(info)
                .addSecurityItem(new SecurityRequirement().addList(headerUserId));
    }

}
