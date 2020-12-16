const NOT_FOUND = -2;
const INACTIVE = -1;
const SUCCESS = 0;
const PROCESSING = 1;

const sleep = (ms) => {
    return new Promise(resolve => setTimeout(resolve, ms));
}

const startTransaction = async (payload) => {
    const url = 'http://localhost:12030/transaction/start/'

    return fetch(url, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    });
}

const startCancel = async (id) => {
    const url = `http://localhost:12030/transaction/revert/${id}`

    return fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
}

const getStatus = async () => {
    const url = 'http://localhost:12030/transaction/status/'

    return fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
}

const getReceipt = async (id) => {
    const url = `http://localhost:12030/transaction/receipt/${id ? id : ""}`

    return fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

}

const abort = async () => {
    const url = 'http://localhost:12030/transaction/abort/'

    return fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
}

const gridTransaction = async () => {
    const url = 'http://localhost:12030/transaction/receipt/success/'

    let promisse = await fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const data = await promisse.json();

    let table = document.querySelector("#transactions");

    for (let i = table.rows.length; i > 1; i--) {
        table.deleteRow(i - 1);
    }

    for (let t of data.content) {

        let row = table.insertRow(table.rows.length);

        row.insertCell(0).innerHTML = t.transactionId;
        row.insertCell(1).innerHTML = t.authorizationCode;
        row.insertCell(2).innerHTML = t.cardApplication;
        row.insertCell(3).innerHTML = t.cardProductName;
        row.insertCell(4).innerHTML = t.cardHiddenPan;
        row.insertCell(5).innerHTML = t.paymentStatus;
    }

}

const maskMoney = () => {
    $(".mascara").attr('maxlength', 18).maskMoney({
        prefix: 'R$ ',
        allowNegative: false,
        thousands: '.',
        decimal: ','
    });
}
