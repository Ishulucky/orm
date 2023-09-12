<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.loan.model.LoanApplicants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan EMI Calculator</title>
<!-- Add Bootstrap CSS link -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    /* Add custom CSS styles */
    body {
        padding: 20px;
    }
    .btn-group {
        margin-bottom: 20px;
    }
    /* Add styling for the table */
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <%
    LoanApplicants e = (LoanApplicants) request.getAttribute("llist");
    %>
    <%=e.getLoanAmount()%>
    <%=e.getNumberOfMonthsRequested()%>
    <%=e.getApplicationDate()%>

    <input type="hidden" name="applicationDate" id="date"
        value="<%=e.getApplicationDate()%>">
    <input type="hidden" name="loanAmount" id="amount"
        value="<%=e.getLoanAmount()%>">
    <input type="hidden" name="numberOfMonthsRequested" id="months"
        value="<%=e.getNumberOfMonthsRequested()%>">
    <button type="button" class="btn btn-primary" onclick="calculateEMI()">Calculate
        EMI</button>
    <button type="button" class="btn btn-primary"
        onclick="createEmiScheduleTable()">Generate Schedule</button>
    <p id="emiResult"></p>

    <div id="scheduleDiv"></div>

    <script>
        function calculateEMI() {
            // Get loan amount and number of months from input fields
            const loanAmount = parseFloat(document.getElementById('amount').value);
            const numberOfMonths = parseInt(document.getElementById('months').value);

            const annualInterestRate = 7.2;
            const monthlyInterestRate = annualInterestRate / 12 / 100;

            // Calculate EMI using the formula
            const emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) /
                (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

            // Display the calculated EMI
            document.getElementById('emiResult').innerHTML = 'EMI: ' + emi.toFixed(2);
        }

        function createEmiScheduleTable() {
            const numberOfMonths = parseInt(document.getElementById('months').value);
            const emi = parseFloat(document.getElementById('emiResult').textContent.split(': ')[1]);
            
            // Clear previous content in the container
            const emitable = document.getElementById('scheduleDiv');
            emitable.innerHTML = '';

            // Create a table element with Bootstrap styling
            const table = document.createElement('table');
            table.className = 'table table-striped';
            
            // Create the table header
            const thead = table.createTHead();
            const headerRow = thead.insertRow();
            const headers = ['Date', 'EMI', 'Cumulative'];
            headers.forEach(headerText => {
                const th = document.createElement('th');
                th.textContent = headerText;
                headerRow.appendChild(th);
            });

            // Calculate and add rows for each month
            const currentDate = new Date(document.getElementById('date').value);
            let cumulativeAmount = 0;
            for (let i = 0; i < numberOfMonths; i++) {
                const row = table.insertRow();
                const dateCell = row.insertCell(0);
                const emiCell = row.insertCell(1);
                const cumulativeCell = row.insertCell(2);

                dateCell.textContent = currentDate.toLocaleDateString();
                emiCell.textContent = emi.toFixed(2);
                cumulativeAmount += emi;
                cumulativeCell.textContent = cumulativeAmount.toFixed(2);

                // Move to the next month
                currentDate.setMonth(currentDate.getMonth() + 1);
            }

            emitable.appendChild(table);
        }
    </script>
</body>
</html>
