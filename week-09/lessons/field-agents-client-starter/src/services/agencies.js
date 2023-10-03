import { BASE_URL } from './baseUrl';

const endpointUrl = BASE_URL + '/agency';

export async function findAllAgencies() {
	const response = await fetch(endpointUrl);
	if (response.ok) {
		return response.json();
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}

export async function findAgencyById(agencyId) {
	const response = await fetch(`${endpointUrl}/${agencyId}`);
	if (response.ok) {
		return response.json();
	} else if (response.status === 404) {
		return Promise.reject(
			new Error(`The requested resource could not be found.`)
		);
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}

async function add(agency) {
	const init = {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agency),
	};

	const response = await fetch(endpointUrl, init);
	if (response.ok) {
		return null;
	} else if (response.status === 400) {
		const errs = await response.json();
		return errs;
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}

async function update(agency) {
	const init = {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agency),
	};

	const response = await fetch(`${endpointUrl}/${agency.agencyId}`, init);
	if (response.ok) {
		return null;
	} else if (response.status === 400) {
		const errs = await response.json();
		return errs;
	} else if (response.status === 404) {
		return Promise.reject(
			new Error(`The requested resource could not be found.`)
		);
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}

export async function saveAgency(agency) {
	return agency.agencyId > 0 ? update(agency) : add(agency);
}

export async function deleteAgencyById(agencyId) {
	const init = {
		method: 'DELETE',
	};

	const response = await fetch(`${endpointUrl}/${agencyId}`, init);
	if (response.ok) {
		return Promise.resolve();
	} else if (response.status === 404) {
		return Promise.reject(
			new Error(`The requested resource could not be found.`)
		);
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}
