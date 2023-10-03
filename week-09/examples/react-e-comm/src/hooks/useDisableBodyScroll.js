import { useEffect } from 'react';

export default function useDisableBodyScroll(show) {
	useEffect(() => {
		document.body.style.overflow = show ? 'hidden' : 'unset';
	}, [show]);
}
