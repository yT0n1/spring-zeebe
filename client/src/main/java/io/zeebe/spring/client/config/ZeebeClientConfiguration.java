package io.zeebe.spring.client.config;

import io.zeebe.client.TasksClient;
import io.zeebe.client.TopicsClient;
import io.zeebe.client.WorkflowsClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ZeebeClientConfiguration {

    @Bean
    public ZeebeClientProperties properties() {
        return ZeebeClientProperties.DEFAULT;
    }

    @Bean
    public SpringZeebeClient springZeebeClient(final ZeebeClientProperties properties, final ApplicationEventPublisher publisher) {
        return new SpringZeebeClient(properties, publisher);
    }

    @Bean
    public WorkflowsClient workflowsClient(final SpringZeebeClient client) {
        return client.workflows();
    }

    @Bean
    public TasksClient tasksClient(final SpringZeebeClient client) {
        return client.tasks();
    }

    @Bean
    public TopicsClient topicsClient(final SpringZeebeClient client) {
        return client.topics();
    }

}
