window.onload = async () => {
    maskMoney();

    const radios = Array.from(document.querySelectorAll("input[name='cardApplication']"));
    const valueInput = document.querySelector("#value");
    const btnAbort = document.querySelectorAll(".btnAbort");
    const btnExecute = document.querySelector("#btnExecute");
    const status = document.querySelector("#status");
    const cbInstallment = document.querySelector("#installment");
    const receipt = document.querySelector("#receipt");

    const execute = async () => {
        let value = valueInput.value.replaceAll('R$ ', '').replaceAll('.', '').replaceAll(',', '.');

        if (value > 0) {
            let cardApplication = radios.filter(r => r.checked)[0].id;
            let installment = cbInstallment.selectedOptions[0].value;

            let payload = {
                value,
                cardApplication,
                installment
            }

            let rawResponse = await startTransaction(payload);
            let response = await rawResponse.json();
            status.innerText = response.message.replaceAll('\0', '');

            if (rawResponse.status === 200) {
                do {
                    rawResponse = await getStatus();
                    response = await rawResponse.json();
                    status.innerText = response.message.replaceAll('\0', '');
                    if (response.status !== PROCESSING) {
                        if (response.status === SUCCESS) {
                            rawResponse = await getReceipt();
                            if (rawResponse.status === 200) {
                                response = await rawResponse.json();
                                receipt.innerHTML = response.clientHtml + response.merchantHtml;
                            }
                        }
                        break;
                    }
                    await sleep(500);
                } while (rawResponse.status === 200);
            }
        } else {
            status.innerText = "Valor Invalido!";            
        }
        await sleep(2000);
        status.innerText = "";
    }

    btnAbort.forEach(btn => btn.addEventListener('click', abort));
    btnExecute.addEventListener('click', execute);

}