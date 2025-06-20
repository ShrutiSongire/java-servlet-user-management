<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 40px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="number"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h2>Employee Details Form</h2>

    <form action="submitform" method="post">

        <div class="form-group">
            <label for="empId">1. Employee ID:</label>
            <input type="text" id="empId" name="empId" value="${empId}" required>
        </div>

        <div class="form-group">
            <label for="empName">2. Employee Name:</label>
            <input type="text" id="empName" name="empName" value="${empName}" required>
        </div>

        <div class="form-group">
            <label for="empEmail">3. Email:</label>
            <input type="email" id="empEmail" name="empEmail" value="${empEmail}" required>
        </div>

        <div class="form-group">
            <label for="empPhone">4. Phone Number:</label>
            <input type="tel" id="empPhone" name="empPhone" value="${empPhone}" required>
        </div>

        <div class="form-group">
            <label for="empDept">5. Department:</label>
            <input type="text" id="empDept" name="empDept" value="${empDept}" required>
        </div>

        <div class="form-group">
            <label for="empPosition">6. Position:</label>
            <input type="text" id="empPosition" name="empPosition" value="${empPosition}" required>
        </div>

        <div class="form-group">
            <label for="empSalary">7. Salary:</label>
            <input type="number" id="empSalary" name="empSalary" value="${empSalary}" required>
        </div>

        <div class="form-group">
            <label for="empDOB">8. Date of Birth:</label>
            <input type="date" id="empDOB" name="empDOB" value="${empDOB}" required>
        </div>

        <div class="form-group">
            <label for="empGender">9. Gender:</label>
            <select id="empGender" name="empGender" required>
                <option value="">--Select--</option>
                <option value="male" ${empGender == 'male' ? 'selected' : ''}>Male</option>
                <option value="female" ${empGender == 'female' ? 'selected' : ''}>Female</option>
                <option value="other" ${empGender == 'other' ? 'selected' : ''}>Other</option>
            </select>
        </div>

        <div class="form-group">
            <label for="empAddress">10. Address:</label>
            <textarea id="empAddress" name="empAddress" rows="3" required>${empAddress}</textarea>
        </div>

        <div class="form-group">
            <label for="empCity">11. City:</label>
            <input type="text" id="empCity" name="empCity" value="${empCity}" required>
        </div>

        <div class="form-group">
            <label for="empState">12. State:</label>
            <input type="text" id="empState" name="empState" value="${empState}" required>
        </div>

        <div class="form-group">
            <label for="empPin">13. Pin Code:</label>
            <input type="text" id="empPin" name="empPin" value="${empPin}" required>
        </div>

        <div class="form-group">
            <label for="empJoinDate">14. Joining Date:</label>
            <input type="date" id="empJoinDate" name="empJoinDate" value="${empJoinDate}" required>
        </div>

        <div class="form-group">
            <label for="empQualification">15. Qualification:</label>
            <input type="text" id="empQualification" name="empQualification" value="${empQualification}" required>
        </div>

        <input type="submit" value="Submit">

    </form>

</body>
</html>