package components;

import company.Manager;

public class MembersTab extends GeneralTab {
    private Manager manager;

    public MembersTab(Manager manager) {
        super("Members");
        this.manager = manager;

        NewMemberWindow newMemberWindow = new NewMemberWindow(manager, this);
        ReportWindow reportWindow = new ReportWindow(manager);

        createTable(new String[]{"Surname", "Name"});
        addButton("Add new member", newMemberWindow);
        addButton("Generate a raport", reportWindow);
    }

    public void refreshTable() {
        tableView.getItems().clear();

        for(int i = 0; i < manager.getMembers().size(); i++) {
            String[] rowData = new String[2];
            rowData[0] = manager.getMembers().get(i).getSurname();
            rowData[1] = manager.getMembers().get(i).getName();

            tableView.getItems().add(rowData);
        }
    }
}
