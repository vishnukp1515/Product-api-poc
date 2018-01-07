package packageapi;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import java.net.InetAddress;


@Configuration
public class Configurations extends AbstractCassandraConfiguration {

    public static final String KEYSPACE = "product";

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }
    
	@Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", EsClusterName)
                .put("client.transport.ignore_cluster_name", true)
                .build();
        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(
				  new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"packageapi.repository"};
    }
}

