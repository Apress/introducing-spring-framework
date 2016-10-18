@Log
@Configuration
@EnableRabbitMessaging
class MyDocumentsRabbitMQStream implements CommandLineRunner {

	@Autowired
	RabbitTemplate rabbitTemplate

	private String queueName = "docs-pdf"
	private String exchangeName = "mydocuments"
	private String routingKey = ".pdf"

	@Bean
	Queue queue() {
		new Queue(queueName, false)
	}

	@Bean
	DirectExchange exchange() {
		new DirectExchange("mydocuments")
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		BindingBuilder
				.bind(queue)
				.to(exchange)
				.with("docs-pdf")
	}

	@Bean
	SimpleMessageListenerContainer container(CachingConnectionFactory connectionFactory) {
		return new SimpleMessageListenerContainer(
		connectionFactory: connectionFactory,
		queueNames: [queueName],
		messageListener: new MessageListenerAdapter(new Receiver(latch:latch), "receive")
		)
	}

	void run(String... args) {
		log.info "Sending Documents..."
		5.times {
			rabbitTemplate.convertAndSend(exchangeName, routingKey, "Document(id: ${it}, created: ${new Date().format('yyyy-MM-dd HH:mm:ss') })")
			sleep 1000
		}
	}
}

@Log
class MyDocumentsConsumer {

	def receive(String message) {
		log.info "Document Received: ${message}"
	}
}
