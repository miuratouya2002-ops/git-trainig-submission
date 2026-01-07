const stripe = Stripe("Stripeの公開可能キー");

const paymentButton = doucument.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {

	stripe.redirectToCheckout({

		sessionId: sessionId
		
		

	})
});