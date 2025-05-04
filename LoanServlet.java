protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
    double interestRate = Double.parseDouble(request.getParameter("interestRate"));
    int numYears = Integer.parseInt(request.getParameter("numYears"));

    Loan loan = new Loan(interestRate, numYears, loanAmount);
    double monthlyPayment = loan.getMonthlyPayment();
    double totalPayment = loan.getTotalPayment();

    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h2>Loan Results</h2>");
    out.println("Monthly Payment: $" + String.format("%.2f", monthlyPayment) + "<br>");
    out.println("Total Payment: $" + String.format("%.2f", totalPayment));
    out.println("</body></html>");
}
