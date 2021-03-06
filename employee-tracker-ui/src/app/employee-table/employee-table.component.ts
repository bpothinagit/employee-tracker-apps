import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { EmployeeDataService } from './employee-data.service';
import { EmployeeTableDataSource, EmployeeTableItem } from './employee-table-datasource';

// TODO: Replace this with your own data model type
// export interface EmployeeTableItem {
//     id: number;
//     daysWorked: number;
//     vacationDaysRequested: number;
//     vacationDays: number;
// }

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<EmployeeTableItem>;
  dataSource: EmployeeTableDataSource;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  ELEMENT_DATA! : EmployeeTableItem[];
  displayedColumns: string[] = ['id', 'daysWorked', 'vacationDaysRequested', 'vacationDays'];

  constructor(private service:EmployeeDataService) {
    this.dataSource = new EmployeeTableDataSource();
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}
