document.getElementById("checkBtn").addEventListener("click", function () {

    chrome.tabs.query(
        { active: true, currentWindow: true },

        function (tabs) {

            let url = tabs[0].url;

            let score = 0;

            // HTTPS check
            if (!url.startsWith("https://")) {
                score++;
            }

            // Length check
            if (url.length > 50) {
                score++;
            }

            // Numbers
            if (/\d/.test(url)) {
                score++;
            }

            // @ symbol
            if (url.includes("@")) {
                score++;
            }

            // Hyphen
            if (url.includes("-")) {
                score++;
            }

            // Keywords
            if (
                url.includes("login") ||
                url.includes("verify") ||
                url.includes("update") ||
                url.includes("bank")
            ) {
                score++;
            }

            let result = "";

            if (score >= 3) {
                result =
                    "PHISHING WEBSITE DETECTED\n\n" + url;
            }
            else {
                result =
                    "SAFE WEBSITE\n\n" + url;
            }

            document.getElementById("result").innerText = result;

        }
    );

});