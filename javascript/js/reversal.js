window.onload = async () => {

    const btnAbort = document.querySelectorAll(".btnAbort");
    const status = document.querySelector("#status");
    const btnCancel = document.querySelector("#btnCancel");

    const cancel = async () => {
        const id = document.querySelector("#transactionId").value;
        let rawResponse = await startCancel(id);
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
        await sleep(2000);
        status.innerText = "";
    }

    btnAbort.forEach(btn => btn.addEventListener('click', abort));
    btnCancel.addEventListener('click', cancel);

}