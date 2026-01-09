const stripe = Stripe('pk_test_51SmmYCFrjSDapsnJNtVKrC4duOy4MKXbPfkUG56QCYMA6EqMM8Ilj8SxZMvGEvlWH5HV9W3NT9vVXwu5FNDfOdFg00JTdHokXR');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
	stripe.redirectToCheckout({
		sessionId: sessionId
	})
});