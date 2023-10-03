import { BASE_URL } from './baseUrl';

const endpointUrl = BASE_URL + '/agent';

export async function findAllAgents() {
	const response = await fetch(endpointUrl);
	if (response.ok) {
		return response.json();
	} else {
		return Promise.reject(
			new Error(`Unexpected status code ${response.status}.`)
		);
	}
}

export async function findAgentById(agentId) {
	const response = await fetch(`${endpointUrl}/${agentId}`);
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

async function add(agent) {
	const init = {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agent),
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

async function update(agent) {
	const init = {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(agent),
	};

	const response = await fetch(`${endpointUrl}/${agent.agentId}`, init);
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

export async function saveAgent(agent) {
	return agent.agentId > 0 ? update(agent) : add(agent);
}

export async function deleteAgentById(agentId) {
	const init = {
		method: 'DELETE',
	};

	const response = await fetch(`${endpointUrl}/${agentId}`, init);
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
